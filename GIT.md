# Git Documentation

## Introduction

This document provides an overview of Git, including installation instructions, basic commands, and common branching strategies used in software development projects(Add more details and images if you can).

What is Git? Why is it used in software development projects?
**answer the above questions**

## Installing Git


### For Windows OS
1. Visit the official Git website at [https://git-scm.com/download/win](https://git-scm.com/download/win).  
   The download should begin automatically. If it doesn't, click on the appropriate link for your system (32-bit or 64-bit).

2. Launch the downloaded installer and follow the instructions provided.

3. Select the default options or modify the installation settings based on your preferences.

4. Once the installation is complete, open Command Prompt and confirm the installation by entering:  
   `git --version`.

### For macOS:
  1. **Install using Homebrew**: If you already have Homebrew installed, run the following command:  
   `brew install git`.

2. **If Homebrew is not installed**: To install Homebrew, open Terminal and run the following command:  
   ```
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
   Once Homebrew is installed, proceed with the command:  
   `brew install git`.

3. **Alternative method**: If you prefer, download the `.dmg` installer from [Git's official website](https://git-scm.com/) and follow the on-screen instructions.

4. **Verify the installation**: After the installation is complete, open Terminal and check the Git version by typing:  
   `git --version`.



### For Linux OS:
For Ubuntu/Debian:  
```bash
sudo apt-get update
sudo apt-get install git
```

For Fedora:  
```bash
sudo dnf install git
```

**Verify the installation**:  
After installation, open the terminal and check the Git version by running:  
```bash
git --version
```

## Configuring Git

Once Git is installed, configure it with your name and email address:

```bash
**give the basic commands**
```

This information is used to identify your commits.

## Using Git - Basic Commands

The following are some of the basic Git commands used to manage repositories, track changes, and collaborate with other developers, complete them with the appropriate commands:

### 1. Initializing a Repository

To start tracking changes in a project, navigate to the project directory and run:

```bash

```

### 2. Cloning a Repository

To clone an existing repository, use the following command:

```bash

```

### 3. Staging Changes

Before committing changes, you need to stage them. Use the following command to stage changes:

```bash

```

### 4. Committing Changes

Committing staged changes to the repository:

```bash

```

### 5. Checking Status

Check the status of your working directory:

```bash

```

### 6. Viewing Commit History

View the commit history of the repository:

```bash

```
## Other git commands
For the given commands, explain what they do and how they are used in a project:

### 1. git pull

### 2. git push

### 3. git branch

### 4. git checkout

### 5. git merge

### 6. git rebase

### 7. git log

### 8. git reset

### 9. git tag

### 10. git stash

### 11. git fetch

### 12. git remote

### 13. git diff

### 14. git blame

### 15. git cherry-pick

## Branching Strategies

Define the branching strategies used in your project, such as feature branching, release branching, or GitFlow. Explain how branches are created, merged, and deleted in your workflow, Give examples of common branching commands.

### 1. Creating a Branch



```bash

```

Alternatively, you can combine these commands using:

```bash

```

### 2. Merging Branches



```bash

```

### 3. Resolving Conflicts



```bash

```

### 4. Deleting a Branch



```bash

```

## VERSION CONTROL

**Version control** is a system that records changes to a file or set of files over time so that you can recall specific versions later. It allows multiple contributors to work on a project simultaneously and track modifications to the source code, documents, or any set of files. The primary goals of version control are to manage changes systematically, facilitate collaboration among team members, and provide a history of modifications for future reference.

There are two main types of version control systems, define them and explain the key features of version control systems.

1. **Centralized Version Control Systems (CVCS):** 

2. **Distributed Version Control Systems (DVCS):**

3. **Local Version Control Systems:**

Key features of version control systems include:

