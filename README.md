# System do prezentacji i podstawowej analizy sygnału EKG :heart:
 

Aplikacja ma za zadanie umożliwić użytkownikowi przeglądanie zapisów Holterowskich.</br>
Użytkownik ma możliwość:</br>
* przeglądania zapisów EKG
* ustalania zakresów
* przybliżania przebiegów
* zapisywania sygnałów do plików graficznych
* zapoznania się z danymi dotyczącymi badania

Aplikacja wyznacza miejsce występowania załamków R, które zostały wyznaczone przy użyciu obliczeń matematycznych
wzorowanych na algorytmie Pana - Tompkinsa</br>
Aplikacja działa dla danych pochodzących z urządzeń firmy CardioScan oraz Reynolds</br>

---

# System for presentation and simple analysis of ECG signal :heart:

Application allows view Holter recordings</br>
User has a possibility to:</br>
* view ECG waveform
* set scope
* zoom waveform
* save signal as a image files
* check information about examination

Application determines samples for which appears R-wave. Math calculations based on Pan - Tompkins algorithm were
applied for this purpose</br>
Application works for data from CardioScan devices and Reynolds devices.</br>

![alt text](app_screenshot.png "Application after load data file")

Heart monitor icon credits: https://icons8.com/web-app/14835/Heart-Monitor</br>
JFXUtils library on Apache 2.0 license written by gillius