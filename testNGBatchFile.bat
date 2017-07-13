set projectLocation=C:\Users\Maneesh\workspace\CNet_Global_Updated
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause