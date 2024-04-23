import React from 'react';

const TodoList = ({ todos }) => {
  return (
    <div>
      <h2>Todo List</h2>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.description}</li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
