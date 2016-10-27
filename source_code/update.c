////////////////////////////
//
// Perform update operations
// on the database.
//
////////////////////////////

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include "update.h"

// Add our sql includes
#include <my_global.h>
#include <mysql.h>


// Performs update operations on the sql database
int update(int sock) {

    char USERNAME[BUFSIZE], PASSWORD[BUFSIZE];
    char buffer[BUFSIZE];
    int n;

    // Get the username and password first 
    // to use for validations
    n = read(sock, USERNAME, BUFSIZE - 1);

    if (n < 0) {
        perror("ERROR reading from socket");
        exit(1);
    }

    n = read(sock, PASSWORD, BUFSIZE - 1);

    if (n < 0) {
        perror("ERROR reading from socket");
        exit(1);
    }

    // Receive the first request
    n = read(sock, buffer, BUFSIZE - 1);

    if (n < 0) {
        perror("ERROR reading from socket");
        exit(1);
    }

    // Loop and maintain the connection until the client
    // decides to terminate it
    while (strcmp(buffer, "end") != 0) {

        // Connect to the database
        MYSQL *con = mysql_init(NULL);

        if (con == NULL) {
            perror("ERROR initializing mysql");
            exit(1);
        }

        if(mysql_real_connect(con, "localhost", "haleigh", "onTrack_pass",
                "test", 0, NULL, 0) == NULL)
            fprintf(stdout, "couldn't connect to db\n");

        // Now that we're connected to it, we can update information    
        mysql_query(con, "INSERT INTO Cars VALUES(2, 'Mercedes', 57127)");


        // Buffer to store info coming from socket
        char buffer[BUFSIZE];
        int n;


        /*
        n = read(sock, buffer, BUFSIZE - 1);

        if (n < 0) {
            perror("ERROR reading from socket");
            return 1;
        }
        
        */
    }
    return 0;
}
