import React from 'react';

const ProjectDetail = ({ project }) => {
  return (
    <div>
      <h2>Project Detail</h2>
      <h3>{project.title}</h3>
      <p>Created Date: {project.createdDate}</p>
    </div>
  );
};

export default ProjectDetail;
