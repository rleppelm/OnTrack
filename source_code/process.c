////////////////////////////////////////////////////////////
//
// The main for the child
// process created by onTrackd
// essentially. Basically handles
// inital operations and then 
// passes off requests to specific
// functions
//
// Needs to do:
//  1. Get username and password for validation purposes
//  2. Recieve requests in a loop until receiving an "end"
//  3. Send the request off to either get, put, or del
//
// To implement:
//  1. Validation on login
//
////////////////////////////////////////////////////////////

#include "process.h"
#include "update.h"
#include "retrieve.h"
#include "del.h"

// Utilities
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

// MySQL headers
//#include <my_global.h>
//#include <mysql.h>

int process(int sock) {

	

    // Connect to the database and get basic information
    // like the username and password that is needed to validate
    char EMAIL[BUFSIZE], PASS[BUFSIZE], buffer[BUFSIZE];
    
    bzero(EMAIL, BUFSIZE);
    int n = read(sock, EMAIL, BUFSIZE - 1);
    if (n < 0) {
        perror("ERROR on socket read");
        exit(1);
    }

    bzero(PASS, BUFSIZE);
    n = read(sock, PASS, BUFSIZE - 1);
    if (n < 0) {
        perror("ERROR on socket read");
        exit(1);
    }

    // Now that we have the basic information, we can get our 
    // first request
    bzero(buffer, BUFSIZE);
    n = read(sock, buffer, BUFSIZE - 1);
    if (n < 0) {
        perror("ERROR on socket read");
        exit(1);
    }
    
    // Continue receiving and processing requests
    // until "end" is received
    while (strcmp(buffer, "end") != 0) {
        
        if (strcmp(buffer, "get") == 0)
            retrieve(sock);

        if (strcmp(buffer, "put") == 0)
            update(sock);

        if (strcmp(buffer, "del") == 0)
            del(sock);
    
        bzero(buffer, BUFSIZE);
        n = read(sock, buffer, BUFSIZE - 1);
        if (n < 0) {
            perror("ERROR on socket read");
            exit(1);
        }
    }
    return 0;
}
