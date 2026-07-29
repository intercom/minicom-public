CALL .\fastapi\Scripts\activate.bat
.\fastapi\Scripts\python.exe -m uvicorn main:app --app-dir fastapi --host 127.0.0.1 --port 3000
