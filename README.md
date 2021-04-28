# dentist-test

## Time taken

* Initial setup - 15 min

* Initial reading - 10 min

* Understanding what was needed - 5 min

* Initial dive into code - 10 min

* Thinking about implementation - 30 min

* Looking up Thymeleaf (never used it) - 1 hour

* Implementing - 10 hours

## What was hard

Since most things were easy, I will just write what was hard instead

* Understanding how Thymeleaf works since I have never used it.
* Understanding the best way to solve this test solution was. The better the idea, the easier it is to implement it, less issues and problems arise.
* Small issues like boostrap alignment etc.

## Where I got help

Most things I just googled (errors mostly) and youtube also helped (bootstrap grid basics and boostrap table). Also checked my own previously written code.

## Overview

(est)

### Paigaldusjuhend

Laadi kood alla, installi Maven depencency-d. Mine DentistAppApplication-i alla ja real 16 vajuta rohelist noolt. Nüüd käivitub tomcat server ja minu loodud rakendus. Asub "localhost:8080/" all. Kui on tahtmist andmebaasi vaadata siis see asub "localhost:8080/console" all. UI on (minu arust) selge ja arusaadav ning intuitiivne. 

#### Lihtne kasutusjuhend



Juhul kui on tahtmist/vajadust täpsemateks juhisteks, siis all on pikk ja lahtikirjutatud kasutusjuhend.

### Üksipulgi lahtikirjutatud kasutusjuhend:

        Kui tahad uut visiiti registreerida, siis vali ülevalt menüüst "Registreeri uus visiit".
        Järgnevalt avaneb vaade, kust saate uue visiidi registreerida. Selleks vali arsti nimi saadavast
        nimekirjast, vali endale sobiv kuupäev ning vali ka kellaaeg ning vajuta nupule "Registreeri visiidile".
        08 tähendab et visiit algab kell 08:00 ja lõpeb 09:00. Kõik visiidid kestavad 1 tund.
        Kui arvad et läheb kauem kui 1 tund, siis pead ka teise visiidi registreerima peale seda. Kui jätad kuupäeva
        välja tühjaks, ilmub veateade. Kui vastaval arstil on juba visiit sellel kuupäeval ja kellaajal, saate vastava
        veateate.
        Kui tahad vaadata kõiki visiite, vali ülevalt menüüst "Kõik visiidid".
        Avaneb tabeli vaade kõikidest olemasolevatest visiitidest. Kui tahad aga vaadata kindlaid visiite,
        siis vali ülevalt menüüst "Täpsem otsing". Avaneb täpsema otsingu vaade. Tegemist on mittekohustuslikude
        väljadega, ehk saad mõned (või kõik) väljad tühjaks jätta. Kui jätad kõik väljad tühjaks siis tulemus
        on tühi. Kui paned kellaajaks 08 ja jätad teised väljad tühjaks ning vajutad nuppu "Otsi visiite" siis
        järgnevalt ilmuvad kõik visiidid, mis algavad kellajal 08:00. Kui paned nüüd samale kellaajale lisaks
        ka arsti nime, näiteks "Kuusk" ja vajutad nuppu "Otsi visiite", siis järgenavalt ilmuvad visiidid,
        mis on tehtud arstile "Kuusk" kellaajal 08:00.
        Järgnev käib visiidi kusutamise kohta. Sinna saad kui valid ülevalt menüüst
        "Kõik visiidid" või "Täpsem otsing" (täpsema otsingu puhul tuleb otsing teha). Kusutamiseks
        otsi visiit, mida tahad kustutada ning mine hiirega "X" peale ning vajuta. Ilmub uus vaade teatega
        "Visiit kustutatud".
        Järgnev käib visiidi muutmise kohta. Sinna saad kui valid ülevalt menüüst
        "Kõik visiidid" või "Täpsem otsing" (täpsema otsingu puhul tuleb otsing teha). Muutmiseks
        otsi visiit, mida tahad muuta ning mine hiirega "Muuda visiiti" peale. Avaneb uus vaade, millega
        saate visiiti muuta. Saate muuta nii arsti, kuupäeva kui ka kellaaega. Juhul kui uuel arstil on juba
        visiit teie valitud kellaajal, ilmub veateade. Kui jätate kuupäeva lahtri tühjaks, ilmub samuti
        veateade.
