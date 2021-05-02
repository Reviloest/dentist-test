# dentist-test

## Time taken

* Initial setup - 15 min

* Initial reading - 10 min

* Understanding what was needed - 5 min

* Initial dive into code - 10 min

* Thinking about implementation - 30 min

* Looking up Thymeleaf (never used it) - 1 hour

* Implementing - 10 hours

* Problems - 2 hours

* Total time - 14h 10 min

* Developed on Linux, also tested on Windows 10.

## Where I got stuck

* I didn't know how I could send variables (objects, lists etc) along with Thymeleaf form. Quick Google search showed me that I had to declare Model model in controller and then I could use that to define variables. Took 10 mins.

* I don't understand why I couldn't retrieve date (object Date) from html date picker. Turns out it's actually string. This took me about 1h 30 min to fix. Tried googling but no help. Then it just clicked - it can't be a hard solution, gonna try a different data type - string and suddenly I got it working.

* Bootstrap refresher (YouTube, no massive copy-pasteing), 20 min.

## What was hard

Since most things were easy, I will just write what was hard instead

* Understanding how Thymeleaf works since I have never used it.
* Understanding the best way to solve this test solution was. The better the idea, the easier it is to implement it, less issues and problems arise.
* Small issues like boostrap alignment etc.

## Overview

(est)

### Paigaldusjuhend

Laadi kood alla, installi Maven depencency-d. Mine DentistAppApplication-i alla ja real 16 vajuta rohelist noolt. Nüüd käivitub tomcat server ja minu loodud rakendus. Asub "localhost:8080/" all. Kui on tahtmist andmebaasi vaadata siis see asub "localhost:8080/console" all. UI on (minu arust) selge ja arusaadav ning intuitiivne. 

#### Lihtne kasutusjuhend

* Tahad uut visiiti registreerida - alguses avanebki see vaade. Kui olete mujal siis see vaade avaneb "Registreeri visiit" alt ülevalt menüüst. Siin saate uue registreerimise teha.
* Tahad vaadata kõiki visiite - ülevalt menüüst "Kõik visiidid" alt.
* Tahad kindlaid visiite vaadata - ülevalt menüüst "Täpsem otsing" alt. Otsingu loogika on "Üksipulgi lahtikirjutatud kasutusjuhend"-i peatüki 2.1 all kirjas.
* Tahad muuta visiiti - ülevalt menüüst "Kõik visiidid" või "Täpsem otsing" alt -> otsi üles visiit mida tahad muuta -> "Muuda" peal vajutada. Avaneb aken, kust saad visiidi andmeid muuta.
* Tahad kustutada visiiti - ülevalt menüüst "Kõik visiidid" või "Täpsem otsing" alt -> otsi üles visiit mida tahad kustutada -> "X" peal vajutada. Avaneb aken, kus on tulemus kirjas.

* Juhul kui on tahtmist/vajadust täpsemateks juhisteks, siis all on pikk ja lahtikirjutatud kasutusjuhend.

### Üksipulgi lahtikirjutatud kasutusjuhend:

        1.0 
        Kui tahad uut visiiti registreerida, siis vali ülevalt menüüst "Registreeri uus visiit".
        Järgnevalt avaneb vaade, kust saate uue visiidi registreerida. Selleks vali arsti nimi saadavast
        nimekirjast, vali endale sobiv kuupäev ning vali ka kellaaeg ning vajuta nupule "Registreeri visiidile".
        08 tähendab et visiit algab kell 08:00 ja lõpeb 09:00. Kõik visiidid kestavad 1 tund.
        Kui arvad et läheb kauem kui 1 tund, siis pead ka teise visiidi registreerima peale seda. Kui jätad kuupäeva
        välja tühjaks, ilmub veateade. Kui vastaval arstil on juba visiit sellel kuupäeval ja kellaajal, saate vastava
        veateate.
        2.0
        Kui tahad vaadata kõiki visiite, vali ülevalt menüüst "Kõik visiidid".
        Avaneb tabeli vaade kõikidest olemasolevatest visiitidest.
        2.1
        Kui tahad aga vaadata kindlaid visiite,
        siis vali ülevalt menüüst "Täpsem otsing". Avaneb täpsema otsingu vaade. Tegemist on mittekohustuslikude
        väljadega, ehk saad mõned (või kõik) väljad tühjaks jätta. Kui jätad kõik väljad tühjaks siis tulemus
        on tühi. Kui paned kellaajaks 08 ja jätad teised väljad tühjaks ning vajutad nuppu "Otsi visiite" siis
        järgnevalt ilmuvad kõik visiidid, mis algavad kellajal 08:00. Kui paned nüüd samale kellaajale lisaks
        ka arsti nime, näiteks "Kuusk" ja vajutad nuppu "Otsi visiite", siis järgenavalt ilmuvad visiidid,
        mis on tehtud arstile "Kuusk" kellaajal 08:00.
        3.0
        Järgnev käib visiidi kusutamise kohta. Sinna saad kui valid ülevalt menüüst
        "Kõik visiidid" või "Täpsem otsing" (täpsema otsingu puhul tuleb otsing teha). Kusutamiseks
        otsi visiit, mida tahad kustutada ning mine hiirega "X" peale ning vajuta. Ilmub uus vaade teatega
        "Visiit kustutatud".
        4.0
        Järgnev käib visiidi muutmise kohta. Sinna saad kui valid ülevalt menüüst
        "Kõik visiidid" või "Täpsem otsing" (täpsema otsingu puhul tuleb otsing teha). Muutmiseks
        otsi visiit, mida tahad muuta ning mine hiirega "Muuda visiiti" peale. Avaneb uus vaade, millega
        saate visiiti muuta. Saate muuta nii arsti, kuupäeva kui ka kellaaega. Juhul kui uuel arstil on juba
        visiit teie valitud kellaajal, ilmub veateade. Kui jätate kuupäeva lahtri tühjaks, ilmub samuti
        veateade.

## Summary

The solution didn't take too long. Could have taken less time but I wasn't familiar with Thymeleaf. Googled most of my problems. What really helped were my previous solution to another company (not one to one problem but similar) and my previous experiences with Spring Boot, MVC, H2 and so on - that's the reason I didint have any problems with Spring's MVC, logic etc. Also decided to add some basic Bootstrap to make it look nice and formal.
