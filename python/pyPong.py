#Modul import - pygame muss mit pip installiert sein!
import pygame #import alle module. Nachteil: genestete Klassen bzw. deren Methoden (z.B. rect() aus draw) werden bei autocomplete nicht angezeigt. 
#die Zeile 4 ist nicht notwendig, da durch Zeil 2 abgedeckt, aber: besser die einzelnen verwendeten Module nochmal so importieren, damit autocomplete funktioniert, denn nur import pygame importiert zwar alle Module aber autocomplete zeigt die Methoden dann nicht an!
from pygame import draw,display,time,event

import random
import sys






#Höhe und Breite des Fensters
x = 500
y = 500

# Schlägerbreite und -höhe
sbreite = 100
shoehe = 15

#Koordinaten des Schlägers - obere linke Ecke
sx = 200
sy = 450

#Koordinaten des Balles, Am Anfang in der Mitte des Bildschirmes
bx = int(x/2) #Achtung int wegen x/2 erzeugt float!
by = int(y/2)

#Radius des Balles
brad = 15

#Speed des Schlägers
speed = 0

#Bewegungsgeschwindigkeiten des Balles
bxspeed = 1
byspeed = -2

#Leben des Spielers
leben = 3

#------Initialisierung--------------------------
pygame.init()
screen = pygame.display.set_mode([x,y]) # Erstellen eines Screens mit x und y
screen.fill((0,0,0)) #Schwarze Füllung

#Ball wird gezeichnet auf screen in Farbe gelb, Bildschirmmitte, Durchmesser brad und ganz ausgefüllt 0
pygame.draw.circle(screen, (255,255,0), (bx,by), brad, 0)
#Schläger wird gezeichnet
pygame.draw.rect(screen, (255,40,0), (sx,sy,sbreite,shoehe),0 )

#Update the full display Surface to the screen
pygame.display.flip()

#----Methoden

# Schlägerverhalten
def sblock():
    global speed # global, damit auch innerhalb der Methoden änderbar
    #Prüfung, ob Schläger Bildschirmrand erreicht
    if sx <= 0 or sx >= x-sbreite:
        speed = 0

# Ballverhalten
def ballbewegung():
    global bx,by
    bx += bxspeed
    by += byspeed

# Falls gestorben, resetten
def reset():
    global byspeed, bxspeed, leben, bx, by, sx, sy, speed
    sx = 200
    sy = 400
    bx = int(x/2)
    by = int(y/2)
    speed = 0
    bxspeed = random.randint(-2,2)
    if bxspeed == 0:
        bxspeed = 1
    byspeed = random.randint(-2,2)
    if byspeed == 0:
        byspeed = 2
    screen.fill((0,0,0))
    pygame.draw.circle(screen, (255,255,0), (bx,by), brad, 0)
    pygame.draw.rect(screen, (255,40,0), (sx,sy,sbreite,shoehe),0 )
    pygame.display.flip()
    pygame.time.wait(1000) # 1 Sekunde warten

# Wand und wo prallt der Ball ab
def ballblock():
    global byspeed, bxspeed, leben
    # oben
    if by-brad <= 0:
        byspeed *= -1
    # links
    if bx-brad <= 0:
        bxspeed *= -1
    # rechts
    if bx+brad >= x:
         bxspeed *= -1
    #Nähe bzw. auf Schläger
    if by >= 435 and by <=440:
        if bx >= sx-15 and bx <=sx+sbreite+15:
            byspeed *= -1
        else:   #neben Schläger
            leben -= 1
            reset()

#Schlägerbewegung
def sbewegung():
    global sx
    sx += speed

#------Main Loop und event handler
while leben > 0:
    #Keyhandler
    for event in pygame.event.get():
        if event.type == pygame.QUIT: sys.exit()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                speed = -2
            if event.key == pygame.K_RIGHT:
                speed = 2
    
    screen.fill((0,0,0))  # Bildschirm schwarz
    sbewegung() #Schlägerbewegung 
    sblock() #Prüfen ob Schläger Bildschirmrand erreicht
    pygame.draw.rect(screen, (255,40,0), (sx,sy,sbreite,shoehe),0 ) #Schläger zeichnen
    ballbewegung() #Ballbewegung
    ballblock() #Prüfen, ob Ball abprallt
    pygame.draw.circle(screen, (255,255,0), (bx,by), brad, 0)  #Ball zeichnen
    pygame.display.flip()  # Alles auf screen veröffentlichen
    pygame.time.wait(5) #5ms warten

#Ende loop - Ende Programm
print("haha verloren")







    
    

    
