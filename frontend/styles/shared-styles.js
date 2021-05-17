// eagerly import theme styles so as we can override them
import '@vaadin/vaadin-lumo-styles/all-imports';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `

<dom-module id="paper-tags-input-shared-styles" theme-for="paper-tags-input">
  <template>
    <style>      
      :host(.tag) {        
        --paper-tag-input-mixin: {

        };
        --paper-tag-input-input-mixin: {

        };
        --paper-tag-input-chip-mixin: {
          background-color: green;
        };
        --paper-tag-input-icon-mixin: {
          background-color: black;
        };
      }
    </style>
  </template>
</dom-module>
`;

document.head.appendChild($_documentContainer.content);
