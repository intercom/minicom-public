from fastapi import APIRouter

router = APIRouter()


@router.post('/foo')
@router.post('/bar')
async def verify():
    return {'success': True}
