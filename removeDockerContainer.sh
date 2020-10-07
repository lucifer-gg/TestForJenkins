#! /bin/sh
CID=`docker ps -a | grep -w oasis:latest | awk '{print $1}'`
echo $CID
if [ "$CID" != "" ] ; then
    docker stop ${CID}
    docker rm ${CID}
fi

