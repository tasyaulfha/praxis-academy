# Create a folder for your project.
mkdir rhymes
cd rhymes

# To make this directory and empty Git repo do this:
git init 

# I usually create an empty README.txt file for the first commit in my project
# history. 
touch README.txt 
git add README.txt 
git commit -m 'First commit.' 

# Add some explanation about the project to the README file.
echo 'This repo is a collection of my favorite nursery rhymes.' >> README.txt

# Review uncommitted changes. Then commit them.
git status
git diff
git add README.txt
git commit -m 'Added project overview to README.txt'

