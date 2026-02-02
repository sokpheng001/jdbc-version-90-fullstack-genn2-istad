git add .
echo -n "[+] Insert your commit message: "
read msg;
git commit -m "$msg"
git push -u origin master
