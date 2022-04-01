<h1 align="center">Aplikacja Webowa - zadanie rekrutacyjne</h1>
<h3 align="center">Repozytorium z rozwiązanym zadaniem od strony back-endowej</h3>

<!-- TECHNOLOGIE -->

<h4 align="left">✅ Java 11</h4>
<h4 align="left">✅ Spring Boot</h4>
<h4 align="left">✅ Spring Data</h4>
<h4 align="left">✅ Hibernate</h4>
<h4 align="left">✅ PostgreSQL</h4>
<h4 align="left">✅ Lombok</h4>
<h4 align="left">✅ Mockito</h4>
<h4 align="left">✅ Maven</h4>
<h4 align="left">✅ JPA</h4>

<!-- OPIS DZIAŁANIA APLIKACJI -->
## O projekcie

Aplikacja webowa, która pobiera dane z zewnętrznej bazy danych (PostgreSQL), zwracająca dwie listy dla wybranej kolumny:
1) pierwsza zwraca listę rekordów, których wartości się w danej kolumnie powtarzają,
2) droga zwraca listę rekordów, których wartości są unikalne.

<!-- -->
Aplikacja zawiera dwa rozwiązania:
<h4 align="left">1️⃣ pierwsze rozwiązanie, z którego korzysta kontroler (@RestController), odpytuje bazę danych zapytaniem w języku natywnym w bazie danych PostgreSQL - to rozwiązanie jest efektywne i do aplikacji pobiera już tylko rekordy, które spełniają żądane kryteria.</h4>

<h3 align="center">Przykład zapytania query w języku natywnym:</h3>

<div align="center">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/nativeNamedQuery.png">
</div>

<h4 align="left">2️⃣ drugie rozwiązanie pobiera z bazy danych wszystkie rekordy i algorytm tworzy listy spełniające kryterium zadania (rozwiązanie nieefektywne)</h4>

<h3 align="center">Screen z rozwiązania algorytmicznego, szukający rekordów wśród obiektów Java, po stronie aplikacji:</h3>

<div align="center">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/rozwiazanieAlgorytmiczne.png">
</div>

<h3 align="center">Tak wyglądają odpowiedzi serwera na stronie www w przypadku wybrania numeru kolumny</h3>
<h4 align="center">(aplikacja obsługuje wyjątek na wypadek wyboru nieistniejącej kolumny)</h4>
<div align="center">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/kolumna1.png">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/kolumna2.png">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/kolumna3.png">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/kolumna4.png">
  <img src="https://github.com/stepbart/suncodeRecruitment/blob/main/z%C5%82yNumerKolumny.png">  
</div>

<p align="center"><a href="#top">-- DO GÓRY --</a></p>
