package com.intercom.minicom;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;
import org.h2.jdbcx.JdbcDataSource;

public class App {

    public static void main(String[] args) throws IOException, SQLException {
        var ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:file:~/minicom;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=FALSE;DB_CLOSE_DELAY=-1");
        ds.setUser("sa");

        initSchema(ds);

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> cors.addRule(CorsPluginConfig.CorsRule::anyHost));
        });

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500).json(Map.of("error", String.valueOf(e.getMessage())));
        });

        app.post("/foo", ctx -> ctx.json(Map.of("success", true)));
        app.post("/bar", ctx -> ctx.json(Map.of("success", true)));
        app.start(3000);
    }

    private static void initSchema(JdbcDataSource ds) throws IOException, SQLException {
        try (var is = App.class.getClassLoader().getResourceAsStream("schema.sql")) {
            if (is == null) throw new IllegalStateException("schema.sql not found on classpath");
            var sql = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            try (var conn = ds.getConnection(); var stmt = conn.createStatement()) {
                for (var statement : sql.split(";")) {
                    var trimmed = statement.trim();
                    if (!trimmed.isEmpty()) stmt.execute(trimmed);
                }
            }
        }
    }
}
