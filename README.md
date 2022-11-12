# FRC_Offseason_2022
[![CI](https://github.com/Team3256/FRC_Offseason_2022/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/Team3256/FRC_Offseason_2022/actions/workflows/main.yml)

# Quickstart
Clone the repo:

`git clone https://github.com/Team3256/FRC_Offseason_2022.git`

# Starting an assignment
- You can find the assingments [here](https://github.com/Team3256/FRC_Offseason_2022/tree/main/assignments)
- Create a new branch with your name
  - `git checkout -b first-last-swXXa # (replace first and last with your first and last name, XX with the assignment number)`
- Code the assingment
- Pushing code when finished
  - `git add . # stage changes`
  - `git commit -m "Good commit message" # commit code`
  - First push
    - `git push --set-upstream origin first-last # push code to your branch`
    - Needed to create the branch on github
  - Other pushes
    - `git push`
    - Since branch is already on github, you can just git push

# Gradle Tasks
- `Build`
  - Compiles java code
- `Test`
  - Runs all test cases (do this to see if the assignment was completed correctly)
- `simulateJava`
  - Starts the simulation GUI
