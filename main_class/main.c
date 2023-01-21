#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include "jsonlib.h"

// path = "C:/Users/monik/OneDrive/Pulpit/antlr4/parsed.txt"

int main(int arg, char** args){

    if (arg == 1){
        perror("No file specified");
        return 1;
    }
 
    FILE    *textfile;
    char    *text;
    long    numbytes;
     
    textfile = fopen(args[1], "r");
    if(textfile == NULL)
        return 1;
     
    fseek(textfile, 0L, SEEK_END);
    numbytes = ftell(textfile);
    fseek(textfile, 0L, SEEK_SET);  
 
    text = (char*)calloc(numbytes, sizeof(char));   
    if(text == NULL)
        return 1;
 
    fread(text, sizeof(char), numbytes, textfile);
    fclose(textfile);

    // get_all_key(text);
    // get_all_value(text);
    get_value_by_key(text,"animals_age");
    // get_key_by_value(text, "[1, 2, 3, 4]");


    return 0;
}