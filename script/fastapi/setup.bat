pushd fastapi
python3 -m venv .
CALL .\Scripts\activate.bat
.\Scripts\python.exe -m pip install -r requirements.txt
popd
