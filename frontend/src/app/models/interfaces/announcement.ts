import {Driver} from './driver';
import {Journy} from './journy';

export interface Announcement {
  id: number | null,
  name: string | null,
  maxDimentions: number | null,
  goodsType: string | null,
  capacity: number | null,
  driver: Driver | null
  journies: Journy[] | null
}
