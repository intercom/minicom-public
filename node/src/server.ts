import express from 'express';
import morgan from 'morgan';
import { cors } from './middleware/cors';

const app = express();

app.set('port', process.env.PORT || 3000);
app.use(cors);
app.use(morgan('dev'));
app.use(express.urlencoded({ extended: false }));

app.post('/foo', (_req, res) => {
  res.json({ success: true });
});

app.post('/bar', (_req, res) => {
  res.json({ success: true });
});

export default app;
