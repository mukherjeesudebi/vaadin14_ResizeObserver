import { LitElement, html, customElement, css } from 'lit-element';

@customElement('custom-component')
export class CustomComponent extends LitElement {

  original = false;

  static styles = css`
    .no-display{
		display:none;
	}
  `;

  render() {
    return html`
		 <div class="button-bar" part="button-container">
          <slot name="buttonSlot"></slot>
          </div>
     <div class="menu-bar" part="menu-container">
      <slot name="menuSlot"></slot>
     </div>
		`;
  }


  constructor() {
    super();
    const observer = new ResizeObserver(entries => {
      if (entries[0].contentRect.width < 710) {
        if(this._getAllChildrenWidth() > entries[0].contentRect.width){
          window.requestAnimationFrame(() => {
            this._toggleDisplay(false);
          })
        }        
      } else {
        window.requestAnimationFrame(() => {
          this._toggleDisplay(true);
        })
      }


    });
    observer.observe(this);
  }

  _getAllChildrenWidth() {
    var width = 0;
    const allChildren = this.shadowRoot!.querySelector(".button-bar")!.querySelector("slot")!.assignedElements()
    allChildren.forEach(child => {
      width = width + child.clientWidth;
    });
    console.log(width);
    return width;
  }

  _toggleDisplay(original: boolean) {
    if (original) {
      this.shadowRoot!.querySelector(".menu-bar")!.classList.add("no-display");
      this.shadowRoot!.querySelector(".button-bar")!.classList.remove("no-display");
    } else {
      this.shadowRoot!.querySelector(".button-bar")!.classList.add("no-display");
      this.shadowRoot!.querySelector(".menu-bar")!.classList.remove("no-display");
    }
    return false;
  }

}