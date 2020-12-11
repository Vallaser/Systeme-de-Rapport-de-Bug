export interface Bug {
  comments: [
    {
      comment: string,
      dateComment: string,
      developer: {
        avatar: string,
        bugs: [
          null
        ],
        id_developer: 0,
        name: string
      },
      id_comment: 0
    }
  ],
  dateCreation: string,
  description: string,
  developer: {
    avatar: string,
    bugs: [
      null
    ],
    id_developer: 0,
    name: string
  },
  etat: string,
  id_bug: 0,
  priority: string,
  title: string
}
