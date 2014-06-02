wget https://raw.githubusercontent.com/n8han/conscript/master/setup.sh
chmod +x setup.sh
./setup.sh
/home/travis/bin/cs n8han/giter8
/home/travis/bin/g8 file://`pwd` << EOF
test-project
1.0.0-SNAPSHOT
org.example
1.12
http://example.com/git/test-project.git
EOF
cd test-project
