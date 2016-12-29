#include <LiquidCrystal.h>

LiquidCrystal lcd(12,13,4,5,6,7);
char inputBuffer;
int cursorPosRow = 0;
int cursorPosCol = 0;

void setup() {
  lcd.begin(16,2);
  lcd.clear();
  Serial.begin(9600);
}

void loop() {
  if(Serial.available() > 0) {
    inputBuffer = Serial.read();
    
    lcd.setCursor(cursorPosCol, cursorPosRow);
    lcd.print(inputBuffer);
    cursorPosCol++;
  } 
}
