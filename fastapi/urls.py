from fastapi import APIRouter

import api

router = APIRouter()

# router.include_router(blog.router, prefix='/blog')

router.include_router(api.router)
