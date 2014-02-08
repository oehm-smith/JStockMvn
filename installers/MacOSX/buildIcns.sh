#!/bin/sh

PROJECT=JStock
# Create the JStock.icns resource as used by MacOSX
GRAPHIC=../../target/classes/images/splash/jstock2-wording.png
ICONS_DIR=$PROJECT.iconset
ICNS=./$PROJECT.icns
LOCALFILE=./input_image


# Create the graphics
if [ ! -d $ICONS_DIR ]; then
	mkdir $ICONS_DIR
else 
	rm -r $ICONS_DIR/*
fi
if [ ! -d $LOCALFILE ]; then
	mkdir $LOCALFILE
else 
	rm -r $LOCALFILE/*
fi
LOCALFILE=$LOCALFILE/`basename $GRAPHIC`
cp $GRAPHIC $LOCALFILE
for i in 16 32 128 256 512
do
	CMD="sips -z $i $i $LOCALFILE --out $ICONS_DIR/icon_${i}x${i}.png"
	echo CMD: $CMD
	`$CMD`
done

# Create the icns resource
iconutil -c icns $ICONS_DIR


