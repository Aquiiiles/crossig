import React from 'react';
import './App.css';
import FormSample from './views/FormComponents/containers/FormSample';

function App() {
  return (
    <div className="App">
        <FormSample />

      <div>
        <header>
          <h1> Typography</h1>
        </header>
        <div className="text-left pt-5">

          <h1>Heading One (76px)</h1><hr/>

          <h2>Heading Two (60px)</h2><hr/>

          <h3>Heading Three (46px)</h3><hr/>

          <h4>Heading Four (34px)</h4><hr/>

          <h5>Heading Five (34px)</h5><hr/>

          <h6>Heading Six (26px)</h6><hr/>

          <span className="h7">Heading Seven (24px)</span><hr/>

          <span className="h8">Heading Eight (20px)</span><hr/>

          <span className="h9">Heading Nine (20px)</span><hr/>

          <span className="h10">Heading Ten (16px)</span><hr/>

          <span className="body-large">Body large</span><hr/>

          <span className="body-small">Body small</span><hr/>

          <span className="body-label">Body label</span><hr/>

          <a href="https://www.crosig.hr">Link</a><hr/>

          <span className="helper-text">
            Helper text Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
            Why do we use it?
            It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
          </span>
        </div>
      </div>
    </div>
  );
}

export default App;
