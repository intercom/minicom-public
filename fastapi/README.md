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

## Structure

The layout mirrors the Django backend:

- **main.py** -- Application setup: CORS and the root router.
- **urls.py** -- The URL configuration (equivalent to the Django backend's `minicom/urls.py`).
- **api.py** -- The verification endpoints, defined on their own router (equivalent to the Django backend's `minicom/api.py`).

## Adding a new module

Routes are registered explicitly in `urls.py`, just like Django's
`path('blog/', include('blog.urls'))`. To add a `blog` module:

1. Create `blog.py` exposing a router with your routes:

```python
from fastapi import APIRouter

router = APIRouter()


@router.get('/')
async def list_posts():
    return {'posts': []}
```

2. Include it in `urls.py`:

```python
import blog

router.include_router(blog.router, prefix='/blog')
```
