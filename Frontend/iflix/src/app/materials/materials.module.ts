import { NgModule } from '@angular/core';
import {
  MatInputModule,
  MatFormFieldModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatToolbarModule,
  MatSnackBarModule,
} from '@angular/material';

const MaterialModules= [
  MatInputModule,
  MatFormFieldModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatToolbarModule,
  MatSnackBarModule,
];
@NgModule({
  imports: [MaterialModules],
  exports: [MaterialModules]
})
export class MaterialsModule { }
