# ToDoListApp
NOTE: IF YOU WANT TO USE THIS WITHOUT ALL THIS HASSLE BECAUSE YOU ARE AN FREAK THEN YOU CAN ALSO ADD A SIMPLE BASH SCRIPT FOR RUNNING IT.

**javac /home/justpurv/Documents/projects/ToDoListApp/toDoList.java && \
java -cp /home/justpurv/Documents/projects/ToDoListApp toDoList "$@"**  
add your path
**
where to save it,
mkdir -p ~/bin
nvim/nano todo
and save the content in todo file

make it executable you are smart you can do it

then add it to path

export PATH="$HOME/bin:$PATH"

also add it to .bashrc or .zshrc 
and source it 

now you are all set
**

This is a simple command-line ToDo List application written in Java. It allows users to add, display, mark, remove, and clear tasks.

## Features

1. Add tasks
2. Display all tasks
3. Mark tasks as completed
4. Remove tasks
5. Clear all tasks

## Usage

To run the application, use the following commands:

### Add a Task

```sh
java toDoList add "task description"
```

### Display All Tasks

```sh
java toDoList display
```

### Mark a Task as Completed

```sh
java toDoList mark <task_number>
```

### Remove a Task

```sh
java toDoList remove <task_number>
```

### Clear All Tasks

```sh
java toDoList clear
```

## Example

```sh
java toDoList add "Learn Java"
java toDoList add "Complete project"
java toDoList display
java toDoList mark 1
java toDoList remove 2
java toDoList clear
```

## File Structure

```
ToDoListApp/
├── tasks.txt
├── toDoList.class
└── toDoList.java
```
