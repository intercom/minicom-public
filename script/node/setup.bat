setlocal
cd node
call pnpm install
call pnpm db:migrate
