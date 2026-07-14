# FastAPI

Welcome to the FastAPI backend!

There's nothing to be done here for the interview set-up, but feel free to look around! 👀

For all operations, run them from the project root folder.

## Setup

From the project root run  `script/fastapi/setup`

## Starting the server

From the project root run  `script/fastapi/start`

The server runs at http://127.0.0.1:3000 and exposes the two verification endpoints:

- **POST /foo** (validates that the frontend can talk to backend)
- **POST /bar** (validates that the frontend can talk to backend)

Both return `{"success": true}`.
