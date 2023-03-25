1. Omówienie algorytmu

W programie wykorzystałem trzy semafory, z czego jeden został przezemnie zmodyfikowany, tak aby zawierał kolejkę FIFO.
-queueLock
-readersLock
-wrtiersLock


Czytelnik:
 1)zajmuje semafor queueLock i tym samym zostaje dodany na koniec kolejki
 2)zajmuje semafor readersLock i inkrementuje licznik czytelników w bibliotece
 3)jesli jest pierwszym czytelnikiem, zajmuje semafor writersLock, tak aby żaden pisarz nie miał dostępu do zasobu
 4)zwalnia semafor readersLock
 5)zwalnia semfaor queueLock i zostaje pobrany z kolejki
 6)wykonuje swoją pracę
 7)zajmuje semafor readersLock i dekrementuje licznik czytelników w bilbliotece
 8)zwalnia semafor readersLock


Pisarz:
 1)zajmuje semafor queueLock i zostaje dodany na koniec kolejki
 2)zajmuje smefaor writersLock i inkrementuje licznik pisarzy w bibliotece
 3)zwalnia semafor queueLock i zostaje pobrany z kolejki
 4)wykonuje swoją pracę
 5)zwalnia semafor writersLock i dekrementuje licznik pisarzy


2. Sposób uruchomienia programu
mvn clean compile assembly:single
java -cp Library-core/target/Library-core-1.0-SNAPSHOT.jar run.Run <number_of_readers> <number_of_writers>   <-- komenda do uruchomenia programu z dwoma argumentami. Pierwszy to liczba czytelników, a drugi to liczba pisarzy

np: java -cp Library-core/target/Library-core-1.0-SNAPSHOT.jar run.Run 2 5  <-- uruchomi program z dwoma czytelnikami i pięcioma pisarzami

Aby wygenerować pokrycie testami jednostkowymi:
mvn clean install
firefox ./testing/target/site/jacoco-aggregate/index.html              <-- otwarcie raportu pokrycia jednostkowego projektu w przeglądarce firefox

**Nie udało mi się wygenerować raportu bezpośrednio w Sonarqub-ie. Raport generowałem za pomocą jacoco, a następnie importowałem go do sonarqube.
Aby podejrzeć raport w sonarqub-ie uruchamiałem komendy:
mvn clean install
mvn sonar:sonar -Dsonar.projectKey=Library -Dsonar.host.url=http://localhost:9000 -Dsonar.login=30151caf2b7a13a03365a53a1f728d0248d35177
