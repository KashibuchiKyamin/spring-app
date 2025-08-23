export const gridjsLanguageConfig = {
    search: {
        placeholder: '検索する値を入力してください。',
    },
    sort: {
        sortAsc: '昇順ソート',
        sortDesc: '降順ソート',
    },
    pagination: {
        previous: '<',
        next: '>',
        navigate: (page, pages) => `${pages}ページ中${page}ページ目を表示`,
        page: (page) => `${page}ページ`,
        // 表の下部に表示する件数の順序はライブラリに依存のため変更できない。「全15件中　1～10件を表示」という書き方はできない。
        showing: ' ',
        to: 'から',
        of: '件目を表示中（全',
        results: '件）'
    },
    loading: '読み込み中...',
    noRecordsFound: 'データがありませんでした。',
    error: 'エラーが発生しました。',
};

export const gridjsStyleConfig = {
    th: {
        backgroundColor: "royalblue",
        color: "white",
        textAlign: "center",
        border: "1px solid #ccc"
    },
    td: {
        border: "1px solid #ccc"
    },
};