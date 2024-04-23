import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

const fetchProjects = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/projects`);
    return response.data;
  } catch (error) {
    console.error('Error fetching projects:', error);
    throw error;
  }
};

const addProject = async (projectData) => {
  try {
    const response = await axios.post(`${BASE_URL}/projects`, projectData);
    return response.data;
  } catch (error) {
    console.error('Error adding project:', error);
    throw error;
  }
};

const deleteProject = async (projectId) => {
  try {
    const response = await axios.delete(`${BASE_URL}/projects/${projectId}`);
    return response.data;
  } catch (error) {
    console.error(`Error deleting project with id ${projectId}:`, error);
    throw error;
  }
};

const fetchProjectById = async (projectId) => {
  try {
    const response = await axios.get(`${BASE_URL}/projects/${projectId}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching project with id ${projectId}:`, error);
    throw error;
  }
};

const fetchTodosByProjectId = async (projectId) => {
  try {
    const response = await axios.get(`${BASE_URL}/todos/projects/${projectId}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching todos for project with id ${projectId}:`, error);
    throw error;
  }
};

const addTodo = async (projectId, todoData) => {
  try {
    const response = await axios.post(`${BASE_URL}/${projectId}/todos`, todoData);
    return response.data;
  } catch (error) {
    console.error('Error adding todo:', error);
    throw error;
  }
};

const updateTodo = async (todoId, todoData) => {
  try {
    const response = await axios.put(`${BASE_URL}/todos/${todoId}`, todoData);
    return response.data;
  } catch (error) {
    console.error(`Error updating todo with id ${todoId} in project ${projectId}:`, error);
    throw error;
  }
};

const deleteTodo = async (todoId) => {
  try {
    const response = await axios.delete(`${BASE_URL}/todos/${todoId}`);
    return response.data;
  } catch (error) {
    console.error(`Error deleting todo with id ${todoId} in project ${projectId}:`, error);
    throw error;
  }
};

export {
 fetchProjects,
  fetchProjectById,
  fetchTodosByProjectId,
  addProject,
  updateProject,
  deleteProject,
  addTodo,
  updateTodo,
  deleteTodo,
};
