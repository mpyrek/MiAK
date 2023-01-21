#ifndef PARSED_JSON
#define PARSED_JSON
#include <stdio.h>
#include <string.h>

void get_all_key(char *text){
    int idx_of_end = 0;
    
    for(int i =0;i < strlen(text); i++) {
        if (text[i] == '=') {
            int flag = 0;
            for(int j = idx_of_end;j < i;j++){
                if (text[j] == ' ') flag = 1;
                else if (flag == 1) printf("%c",text[j]);
            } 
            printf(" ");
        } else if (text[i] == ';'){
            idx_of_end= i + 1;
        }
    }
}


void get_all_value(char *text){
    int idx_of_end = 0;
    
    for(int i =0;i < strlen(text); i++) {
        if (text[i] == '=') {
            idx_of_end = i + 1;
        } else if (text[i] == ';'){
            for(int j = idx_of_end;j < i;j++) printf("%c",text[j]);
        }
    }
}

void get_value_by_key(char *text, char* key){
    int idx_of_end = 0;
    char *key_begin = strstr(text, key);
    strtok(key_begin, "=;");
    printf("%s",strtok(NULL, "=;"));
}

void get_key_by_value(char* text, char* value){
    char* check = strtok(text, "=;");
    while(check != NULL){
        char* temp = check;
        check = strtok( NULL, "=;");
        if (strstr(check, value) != NULL) {
            strtok(temp, " ");
            temp = strtok(NULL, " ");
            printf("%s", temp);
            break;
        }
    }    
}


#endif
