#
# *****************************************************************************
#  $Id: makefile 23 2013-02-17 22:50:58Z mkwayisi $
#  ----------------------------------------------------------------------------
#  Authored by Michael Kwayisi. Copyright (c) 2009-2013. All rights reserved.
#  Please send your comments to mkwayisi@gmail.com | Web: michaelkwayisi.com
#  ----------------------------------------------------------------------------
#  Redistribution and use in source and binary forms, with or without
#  modification, are permitted provided that the following conditions are
#  stringently met:
#    1. Redistributions of source code must retain the above copyright notice,
#       this list of conditions, and the following disclaimer.
#    2. Redistributions in binary form must reproduce the above copyright
#       notice, this list of conditions, and the following disclaimer in the
#       documentation and/or other materials provided with the package.
#    3. The end-user documentation included with the redistribution, if any,
#       must include the following acknowledgment:
#          "This product includes software developed by Michael Kwayisi"
#       Alternately, this acknowledgment may appear in the software itself,
#       if and wherever such third-party acknowledgments normally appear.
#    4. Neither the name of the software nor the name of its author and/or
#       contributors may be used to endorse or promote products derived from
#       this software without specific prior written permission.
# *****************************************************************************
#

OBJD := obj

FLST := Program Calculator Expression InvalidInputException \
			SyntaxErrorException UnknownOperatorException
SRCS := $(addprefix src/, $(addsuffix .java, $(FLST)))
OBJS := $(addprefix $(OBJD)/, $(addsuffix .class, $(FLST)))

CC := javac
CFLAGS := -Werror -d $(OBJD) -sourcepath src

.PHONY : all clean debug release jar trace launch

all : clean release jar

clean :
	if exist $(OBJD) rd $(OBJD) /s /q

debug : CFLAGS := -g $(CFLAGS)
debug : $(OBJD) $(OBJS)

release : CFLAGS := -g:none $(CFLAGS)
release : $(OBJD) $(OBJS)

jar : $(OBJD) $(OBJS)
	jar -cfm easycalc.jar src/MANIFEST.MF -C obj .

trace :
	cd $(OBJD) && java Program
launch :
	cd $(OBJD) && start java Program

obj/Program.class : src/Program.java
	$(CC) $(CFLAGS) $^
obj/Calculator.class : src/Calculator.java
	$(CC) $(CFLAGS) $^
obj/Expression.class : src/Expression.java
	$(CC) $(CFLAGS) $^
obj/InvalidInputException.class : src/InvalidInputException.java
	$(CC) $(CFLAGS) $^
obj/SyntaxErrorException.class : src/SyntaxErrorException.java
	$(CC) $(CFLAGS) $^
obj/UnknownOperatorException.class : src/UnknownOperatorException.java
	$(CC) $(CFLAGS) $^

$(OBJD) :
	if not exist $@ md $@


