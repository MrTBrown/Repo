<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LED on GPIO18 via php button</title>
</head>
<body>
    
    <form action="raspLED1.php" method="get">
        <input type="submit" value="LED ON" name="on">
        <input type="submit" value="LED OFF" name="off">
    </form>

    <?php

        /* damit der Webserver auch die Rechte hat um alles auszuführen/Skripte,
           sollten die Rechte von var/www/html auch bei 775 liegen. Besitzer und Gruppe dürfen alles 
           -> so können wir Problemlos Dateien per filezilla schieben
           und die Gäste dürfen lesen und ausführen.
           (cd /var/www  ---> ls -all --> gegebenfalls mit chmod ändern)
           Der Besitzer/Gruppe sollte www-data sein (gegebenfalls mit chown ändern), 
           dem Pi angehört  (groups pi ---> zeigt alle Gruppen, denen pi angehört. Da steht muss dann auch www-data stehen)
           Geht bei mir so.
           Gegebenfalls müssen noch www-data in die Gruppe gpio genommen werden "adduser"
           oder unter sudo visuo ( öffnet /etc/sudoers)  www-data Skriptfreigabe ohne Passworte erteilt werden. 
           für alle !!!UNSICHER!!!--> www-data ALL=NOPASSWD: ALL
           oder nur für das Skript--> www-data ALL=(ALL) NOPASSWD: /var/www/html/raspLED1.php */

        // setze GPIO 18 (wiPi 1) auf out. Geht auch mit "gpio -g mode 18 out"
         exec("gpio mode 1 out");    

        // Teste, ob Variable gesetzt ist (erster Start der SEite ist sie leer) und führe wenn true das Skript aus.
        if(isset($_GET['on'])) {
            exec("gpio write 1 1");
        }

        if(isset($_GET['off'])) {
            exec("gpio write 1 0");
        }

    ?>



    </body>

</html>