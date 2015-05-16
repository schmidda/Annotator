#!/bin/bash
if [ ! -d annotator ]; then
  mkdir annotator
  if [ $? -ne 0 ] ; then
    echo "couldn't create annotator directory"
    exit
  fi
fi
if [ ! -d annotator/WEB-INF ]; then
  mkdir annotator/WEB-INF
  if [ $? -ne 0 ] ; then
    echo "couldn't create annotator/WEB-INF directory"
    exit
  fi
fi
if [ ! -d annotator/WEB-INF/lib ]; then
  mkdir annotator/WEB-INF/lib
  if [ $? -ne 0 ] ; then
    echo "couldn't create annotator/WEB-INF/lib directory"
    exit
  fi
fi
rm -f annotator/WEB-INF/lib/*.jar
cp dist/Annotator.jar annotator/WEB-INF/lib/
cp lib/*.jar annotator/WEB-INF/lib/
cp web.xml annotator/WEB-INF/
jar cf annotator.war -C annotator WEB-INF 
echo "NB: you MUST copy the contents of tomcat-bin to \$tomcat_home/bin"
