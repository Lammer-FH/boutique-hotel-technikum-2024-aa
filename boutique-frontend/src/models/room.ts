export class Room {
    id: number;
    name: string;
    description: string;
    imageUrl: string;
    price: number;
    extras: string[];
  
    constructor(id: number, name: string, description: string, imageUrl: string, price: number, extras: string[]) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.imageUrl = imageUrl;
      this.price = price;
      this.extras = extras;
    }
}