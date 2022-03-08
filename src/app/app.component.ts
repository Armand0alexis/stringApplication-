import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StringService } from './string.service';
import { Strings } from './strings';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  [x: string]: any;
  public strings!: Strings[];
  public deleteString!: Strings;

  constructor(private strignService: StringService) { }

  ngOnInit(): void {
      this.getStrings();
  }

  public getStrings(): void {
    this.strignService.getStrings().subscribe(
      (response:Strings[]) => {
        this.strings = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  public onAddString(addForm: NgForm): void {
    document.getElementById('add-string-form')?.click();
    this.strignService.addStrings(addForm.value).subscribe(
      (response: String) =>{
        console.log(response);
        this.getStrings();
        addForm.reset();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
        addForm.reset();
      }
    )
  }

  // public searchStrings(key: string): void {
  //   console.log(key);
  //   const results: Strings[] = [];
  //   for (const str of this.strings) {
  //     if (str.inputString.toLowerCase().indexOf(key.toLowerCase()) !== -1
  //     || str.searchString.toLowerCase().indexOf(key.toLowerCase()) !== -1
  //     || str.count.toLowerCase().indexOf(key.toLowerCase()) !== -1) 
  //      (str.isFound !== null
  //     || str.caseSensitive !== null)
  //      {
  //       results.push(str);
  //     }
  //   }
  //   this.strings = results;
  //   if (results.length === 0 || !key) {
  //     this.getStrings();
  //   }
  // }

  public onDeleteString(stringId: number): void{
    this.strignService.deleteString(stringId).subscribe(
      (Response: void) =>{
        console.log(Response);
        this.getStrings();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      )
    
  }

  public onOpenModal2(string: null, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add'){
      button.setAttribute('data-target', '#addStringModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onOpenModal(strings: Strings, mode: string): void{
    const conatiner = document.getElementById("main-container");
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    // if(mode === 'add'){
    //   button.setAttribute('data-target', '#addStringModal');
    // }
    if(mode === 'delete'){
      this.deleteString = strings;
      button.setAttribute('data-target', '#deleteStringModal');
    }
    conatiner?.appendChild(button);
    button.click();
  }




}
