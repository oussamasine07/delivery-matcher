import {Announcement} from './announcement';
import {Sender} from './sender';
import {Pack} from './pack';

export interface Application {
  id: number | null,
  applicationDate: Date | null,
  applicationStatus: string | null,
  announcement: Announcement | null,
  sender: Sender | null,
  pack: Pack | null
}
