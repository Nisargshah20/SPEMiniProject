echo hello
g++ $1 < $2 2>$3
g++ $1 -o tc
./tc < $2 > $4