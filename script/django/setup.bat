pushd django
python3 -m venv .
CALL .\Scripts\activate.bat
.\Scripts\python.exe -m pip install -r requirements.txt
.\Scripts\python.exe .\manage.py makemigrations
.\Scripts\python.exe .\manage.py migrate
popd