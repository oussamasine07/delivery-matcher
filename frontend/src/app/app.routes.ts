import { Routes } from '@angular/router';
import {LoginComponent} from './components/pages/login/login.component';
import {RegisterComponent} from './components/pages/register/register.component';
import {LayoutComponent} from './components/layout/layout.component';
import {DashboardComponent} from './components/pages/dashboard/dashboard.component';
import {
  AnnouncementIndexComponent
} from './components/pages/announcement/announcement-index/announcement-index.component';
import {JournyIndexComponent} from './components/pages/journy/journy-index/journy-index.component';
import {
  AnnouncementSenderComponent
} from './components/pages/announcement/announcement-sender/announcement-sender.component';

export const routes: Routes = [
  {
    path: "",
    component: LoginComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "app",
    component: LayoutComponent,
    children: [
      {
        path: "",
        component: DashboardComponent
      },
      {
        path: "announcement",
        component: AnnouncementIndexComponent
      },
      {
        path: "announcement-sender",
        component: AnnouncementSenderComponent
      },
      {
        path: "journy",
        component: JournyIndexComponent
      }
    ]
  }
];
