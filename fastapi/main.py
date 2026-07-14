from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

import urls

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=['*'],
    allow_methods=['*'],
    allow_headers=['*'],
)

app.include_router(urls.router)
