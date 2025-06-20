import {City} from './city';
import {Announcement} from './announcement';

export interface Journy {
  id: number | null,
  name: string | null,
  departureDestination: City | null,
  finalDestination: City | null,
  passedByCities: City[] | null,
  announcement: Announcement
}
