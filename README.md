# Bankovní systém (Java)

Jednoduchá **konzolová** aplikace v Javě, která simuluje bankovní účet s volitelným **kontokorentem** a **spotřebitelským úvěrem**. Projekt je psaný česky (proměnné, texty v konzoli) a je vhodný jako cvičení OOP (dědičnost, přetěžování, práce se stavem).

> Repo: *Bank-System_java*

---

## ✨ Funkce
- ✅ Založení bankovního účtu (jméno, adresa, platební karta)
- 💳 Vklady a výběry
- 🧾 Zobrazení informací o účtu (zůstatek, karta, adresa)
- 🧰 **Kontokorent** (limit, čerpání, splácení)
- 🏦 **Spotřebitelský úvěr** (schválení, čerpání, splátky, info)
- 🧭 Hlavní menu a jednoduché textové rozhraní v češtině

> Pozn.: Názvy tříd a polí vycházejí z nahraných souborů: `BankovniUcet`, `Kontokorent`, `SpotrebitelskyUver`, `Main`.

---

## 🗂 Struktura projektu
├─ BankovniUcet.java # Základní třída účtu (vklady, výběry, info, menu)
├─ Kontokorent.java # Rozšíření účtu o kontokorent (limit ~ 10 000 Kč)
├─ SpotrebitelskyUver.java # Rozšíření účtu o spotřebitelský úvěr
└─ Main.java # Vstupní bod aplikace


---

## 🧠 Architektura a OOP
- **`BankovniUcet`** – správa účtu, scanner/konzole, přepínání voleb, zůstatek, osobní údaje, karta.
- **`Kontokorent extends BankovniUcet`** – přidává logiku limitu, čerpání, automatické vyrovnání při vkladu.
- **`SpotrebitelskyUver extends BankovniUcet`** – práce s úvěrem (výše, splátka, příznak `jeUver`, přehled).
- **`Main`** – pouze vytvoří instanci účtu a spustí aplikaci (`spustAplikaci()`).

> Implementace je **konzolová** (třídy využívají `Scanner`). GUI ani databáze nejsou potřeba.

---

## 🚀 Rychlé spuštění

### Požadavky
- Java **17+** (doporučeno), fungovat bude i na starších verzích 11+
- Není potřeba žádná knihovna třetí strany

### Kompilace a běh (terminál)
```bash
# Kompilace všech .java souborů
javac *.java

# Spuštění aplikace
java Main
