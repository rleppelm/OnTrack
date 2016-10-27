#########################
#
# Must use these flags to
# compile for MariaDB
#
# for Amazon server version
# -I/usr/include/mysql
# -L/usr/lib64 -lmysqlclient
#
#########################

all: onTrackd

onTrackd: onTrackd.c process.c retrieve.c update.c del.c onTrackd.h retrieve.h update.h del.h process.h
	gcc -I/usr/include/mysql onTrackd.c retrieve.c update.c del.c process.c -L/usr/lib64 -lmysqlclient -o onTrackd

clean:
	rm -f onTrackd
