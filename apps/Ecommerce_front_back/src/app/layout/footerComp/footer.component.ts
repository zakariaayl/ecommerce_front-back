import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FaConfig, FaIconComponent, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from '../../font-awesome-icons';

@Component({
  selector: 'app-footer',
  imports: [CommonModule,FaIconComponent],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss',
})
export class FooterComponent {
  private faIconLibrary=inject(FaIconLibrary);
  private faConfig=inject(FaConfig);
  ngOnInit(): void {
    this.initFontAwesome();
  }
  private initFontAwesome(){
    this.faConfig.defaultPrefix='far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }

}
