import React, { useState, useEffect } from 'react';
import ProjectList from './components/ProjectList';
import ProjectDetail from './components/ProjectDetail';
import TodoList from './components/TodoList';
import * as api from './services/api';

const App = () => {
  const [projects, setProjects] = useState([]);
  const [selectedProject, setSelectedProject] = useState(null);
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const projectsData = await api.fetchProjects();
      setProjects(projectsData);
    };

    fetchData();
  }, []);

  const handleProjectClick = async (projectId) => {
    const projectData = await api.fetchProjectById(projectId);
    const todosData = await api.fetchTodosByProjectId(projectId);
    setSelectedProject(projectData);
    setTodos(todosData);
  };

  return (
    <div>
      <ProjectList projects={projects} onClick={handleProjectClick} />
      {selectedProject && <ProjectDetail project={selectedProject} />}
      <TodoList todos={todos} />
    </div>
  );
};

export default App;
