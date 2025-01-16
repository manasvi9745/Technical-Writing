# Git Documentation

## Introduction

This document provides an overview of Git, including installation instructions, basic commands, and common branching strategies used in software development projects(Add more details and images if you can).

**Git** is a tool used to track file changes, especially when multiple people are working on a project. It is a **version control system**, which means it helps you manage different versions of your files and makes it easier to work on a project as a team. 

### Why Git is used in software development projects:
1. **Track Changes**: Git keeps a history of all file changes, so you can see what has been modified and when.
2. **Collaboration**: Multiple people can work on the same project without overwriting each other's work. Git helps merge their changes.
3. **Error Recovery**: If you make a mistake, you can return to your work's earlier version.
4. **Branching and Merging**: You can create separate branches (copies) of a project to try new ideas or features without affecting the main project. Once everything is ready, you can combine the changes back.
5. **Transparency**: It shows who made what changes, making it easier to understand the progress and contributions of team members.

Git is popular in software development because it is fast, reliable, and helps teams work together effectively.


## Installing Git


### Windows

1. Download the Git installer for Windows from the official website: [Git for Windows](https://gitforwindows.org/).
2. Run the downloaded installer and follow the on-screen instructions.
3. Choose the default settings or customize the installation according to your preferences.


## Configuring Git

Once Git is installed, configure it with your name and email address:

```bash
git config --global user.name "Your Name"
git config --global user.email "your_email@example.com"

```

This information is used to identify your commits.

## Using Git - Basic Commands

The following are some of the basic Git commands used to manage repositories, track changes, and collaborate with other developers, complete them with the appropriate commands:

### 1. Initializing a Repository

To start tracking changes in a project, navigate to the project directory and run:

```bash
git init
```

### 2. Cloning a Repository

To clone an existing repository, use the following command:

```bash
git clone <repository_url>
```

### 3. Staging Changes

Before committing changes, you need to stage them. Use the following command to stage changes:

```bash
git add <file_name>
git add 
```

### 4. Committing Changes

Committing staged changes to the repository:

```bash
git commit -m "Your commit message"
```

### 5. Checking Status

Check the status of your working directory:

```bash
git status
```

### 6. Viewing Commit History

View the commit history of the repository:

```bash
git log
```
## Other git commands
For the given commands, explain what they do and how they are used in a project:

### 1. git pull  
Fetches updates from the remote repository and merges them into your current branch. It keeps your local repository up-to-date with the latest changes from others.

### 2. git push  
Uploads changes from your local branch to the remote repository, allowing others to access your updates.

### 3. git branch  
Lists existing branches, creates new branches, or deletes branches. It is used to manage different lines of development in a project.

### 4. git checkout  
Switches to another branch or a specific commit. It is used to work on a different part of the project or review an earlier state.

### 5. git merge  
Combines changes from one branch into the current branch. It is commonly used to integrate feature branches back into the main branch.

### 6. git rebase  
Reapplies commits from your branch onto another branch, creating a cleaner, linear project history. It is useful for integrating changes without unnecessary merge commits.

### 7. git log  
Displays the commit history, showing details like author, date, and changes. It helps track what changes were made and when.

### 8. git reset  
Resets the index and working directory to a previous commit, undoing changes. It is used to fix mistakes or undo commits.

### 9. git tag  
Marks a specific commit with a label, typically used for releases or significant milestones.

### 10. git stash  
Temporarily saves uncommitted changes without committing them. It is helpful when you need to switch branches but want to save ongoing work.

### 11. git fetch  
Downloads changes from the remote repository without merging them. It allows you to inspect updates before applying them.

### 12. git remote  
Manages remote repository connections. It is used to add, remove, or view remote repositories.

### 13. git diff  
Shows differences between commits, branches, or the working directory. It helps review changes before committing or merging.

### 14. git blame  
Displays the last modification for each line in a file, showing who made changes and when. It is useful for debugging or reviewing contributions.

### 15. git cherry-pick  
Applies a specific commit from one branch to another. It allows selective integration of changes without merging the entire branch.
## Branching Strategies

Define the branching strategies used in your project, such as feature branching, release branching, or GitFlow. Explain how branches are created, merged, and deleted in your workflow, Give examples of common branching commands.

### 1. Creating a Branch



```bash
git branch <branch_name>
```

Alternatively, you can combine these commands using:

```bash
git checkout -b <branch_name>
```

### 2. Merging Branches



```bash
git merge <branch_name>
```

### 3. Resolving Conflicts



```bash
git add <resolved_file>
git commit
```

### 4. Deleting a Branch



```bash
git branch -d <branch_name>
```

## VERSION CONTROL

**Version control** is a system that records changes to a file or set of files over time so that you can recall specific versions later. It allows multiple contributors to work on a project simultaneously and track modifications to the source code, documents, or any set of files. The primary goals of version control are to manage changes systematically, facilitate collaboration among team members, and provide a history of modifications for future reference.

There are two main types of version control systems, define them and explain the key features of version control systems.

### Types of Version Control Systems:

1. **Centralized Version Control Systems (CVCS):**  
   In a CVCS, there is a single central server that stores all the versioned files. Developers work on copies of the files by checking them out from the server and then commit their changes back to the central repository.  
   - **Example Tools**: Subversion (SVN), Perforce.  
   - **Key Characteristics**:  
     - All version history is stored on the central server.  
     - Changes are tracked centrally, making it easy to manage.  
     - Requires internet access or a connection to the central server to commit or update changes.  
     - A single point of failure: if the server goes down, version history and collaboration can be disrupted.

2. **Distributed Version Control Systems (DVCS):**  
   In a DVCS, every developer has a complete copy of the entire project history, including all branches and versions. Changes are made locally and can later be pushed to a shared repository.  
   - **Example Tools**: Git, Mercurial.  
   - **Key Characteristics**:  
     - Work can continue offline as all data is stored locally.  
     - Enables easy branching and merging workflows.  
     - Highly resilient: even if the central repository is lost, a complete copy exists on every contributor’s machine.  
     - Supports collaboration through features like pull requests and distributed workflows.

3. **Local Version Control Systems:**  
   A simple system that maintains versions on a single developer's local machine. Changes are tracked by saving differences between file versions in a local database.  
   - **Example Tools**: RCS (Revision Control System).  
   - **Key Characteristics**:  
     - Suitable for individual developers or small projects.  
     - Limited collaboration capabilities since it doesn’t support multiple users.  
     - Lacks the scalability and robust features of CVCS and DVCS.
       
These features make version control systems an essential tool for managing and coordinating development projects efficiently.
Key features of version control systems include:
Git plays a crucial role in **version control**, helping developers manage and track changes to their code over time. Here’s an explanation in simple terms:

### Git's Role in Version Control:
1. **Tracking Changes**: Git monitors every modification to files in a project. Developers can view the history of changes, see what was updated, and understand why changes were made.
   
2. **Collaboration**: When multiple developers work on a project, Git ensures that their work doesn't conflict. It merges their changes and resolves any conflicts that arise.
   
3. **Branching and Merging**:
   - **Branching**: Developers can create "branches" to work on new features or fixes without disturbing the main project (main branch).
   - **Merging**: Once the work is complete, Git combines the changes back into the main branch.
   
4. **Version Snapshots**: Git takes snapshots of the project at various points (commits). These snapshots allow developers to revisit any stage of the project if needed.
   
5. **Error Recovery**: If something goes wrong, Git lets developers revert to an earlier version of their work. This prevents accidental loss of progress.


